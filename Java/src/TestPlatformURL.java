/**
 * @Program: Java
 * @Package: PACKAGE_NAME
 * @Class: TestPlatformURL
 * @Description: 测试windows和mac的平台判断相关函数
 * @Author: cwp0
 * @CreatedTime: 2024/01/14 17:24
 * @Version: 1.0
 */
public class TestPlatformURL {
    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println(os);
        if (os.contains("win")) {
            // Windows
            System.out.println("win");
        } else if (os.contains("mac")) {
            // Mac
            System.out.println("mac");
        } else {
            // Handle other operating systems if needed
            System.out.println("other");
        }
    }
}