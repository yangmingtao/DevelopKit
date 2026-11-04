package cc.yangmingtao

//md5加密

import java.security.MessageDigest

// 1. 定义需要加密的原始字符串（也可以从其他变量获取，如：String source = vars.get("myVar");）
String source = "123456";

try {
    // 2. 获取 MD5 实例
    MessageDigest md = MessageDigest.getInstance("MD5");

    // 3. 执行加密计算，得到字节数组
    byte[] messageDigest = md.digest(source.getBytes("UTF-8"));

    // 4. 将字节数组转换为 32 位小写的十六进制字符串
    StringBuilder sb = new StringBuilder();
    for (byte b : messageDigest) {
        String hex = Integer.toHexString(0xff & b);
        if (hex.length() == 1) {
            sb.append('0');
        }
        sb.append(hex);
    }
    String md5Result = sb.toString();

    // 5. 将加密后的结果存入 JMeter 变量中，供后续请求使用（引用方式：${md5_str}）
    vars.put("md5_str", md5Result);

    log.info("MD5 加密成功: " + md5Result);

} catch (Exception e) {
    log.error("MD5 加密失败: " + e.getMessage(), e);
    throw e;
}