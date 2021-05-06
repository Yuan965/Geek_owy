package XlassLoader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * 
 * @author 75240
 *
 */
public class XlassLoad extends ClassLoader
{
	private static String name = "Hello"; // 文件名
	private static String suffix = ".xlass"; // 文件后缀
	private static String methodName = "hello"; // 方法名
	
    public static void main( String[] args ) throws Exception
    {
    	// 类加载
    	Class<?> clazz = new XlassLoad().findClass(name);
    	// 创建对象
    	Object instance = clazz.getDeclaredConstructor().newInstance();
    	// 实现方法
    	Method mt = clazz.getMethod(methodName);
    	mt.invoke(instance);
    }
    
    @Override
    protected Class<?> findClass(String paramString) throws ClassNotFoundException {
    	// TODO Auto-generated method stub
    	byte[] data = null;
    	InputStream in = null;
    	// 读取文件内容
    	try {
    		in = this.getClass().getResourceAsStream(paramString + suffix);
    		int count = -1; // in.available可能为0，所以不能用0做默认值，否则会出现死循环
    		while(count == -1) {
    			count = in.available();
    		}
    		if(count <= 0) {
    			System.out.println("xlass文件内容为空");
    			throw new ClassFormatError();
    		}
    		data = new byte[count];
    		in.read(data);
			// 转换
			byte[] classByte = this.decode(data);
			return defineClass(paramString, classByte, 0, classByte.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ClassNotFoundException(paramString, e);
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    }
    
    // 解码
    private static byte[] decode(byte[] byteArrary) {
    	byte[] classByte = new byte[byteArrary.length];
    	for (int i = 0; i < byteArrary.length; i++) {
    		classByte[i] = (byte) (255 - byteArrary[i]); 
    	}
    	return classByte;
    }
}
