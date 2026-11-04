package cc.yangmingtao

//批量在数据库中插入数据


import java.text.SimpleDateFormat
StringBuilder sb = new StringBuilder();
sb.append("INSERT INTO student(name, age, create_time) VALUES ");

SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
Random random = new Random();
String chars = "ABCDEFGH123456";

// 假设单次循环插入 500 条，循环 200 次 = 10万条
int batchSize = 500;

for (int i = 0; i < batchSize; i++) {
    // 随机生成名字
    StringBuilder nameSb = new StringBuilder();
    for (int j = 0; j < 6; j++) {
        nameSb.append(chars.charAt(random.nextInt(chars.length())));
    }
    String name = nameSb.toString();
    int age = random.nextInt(71) + 10;
    String createTime = format.format(new Date());

    sb.append("('").append(name).append("', ").append(age).append(", '").append(createTime).append("')");

    if (i < batchSize - 1) {
        sb.append(",");
    }
}

// 将生成的超长 SQL 存入变量
vars.put("batchSql", sb.toString());