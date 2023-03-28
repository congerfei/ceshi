package code.exception;

/**
 * Author: xl
 * date :2020/12/29 10:01
 * description:异常就是程序出现了不正常的情况
 * 解决方案一：用try-catch方式处理异常
 * try {
 *     可能出现异常的代码;
 * } catch(异常类名 变量名) {
 *     异常的处理代码;
 * }
 *
 * 解决方案二：用throws方式处理异常
 * public void 方法名() throws 异常类名 {
 *
 * }
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
// 自定义异常类
class ScoreException extends Exception {
    public ScoreException() {}

    public ScoreException(String message) {
        super(message);
    }
}

class Teacher {
    public void checkScore(int score) throws ScoreException {
        if (score < 0 || score > 100) {
            throw new ScoreException("你给的成绩有误，分数应该在0-100之间");
        } else {
            System.out.println("你给的成绩正常");
        }
    }
}

class Main {
    public static void main(String[] args) {
        try {
            Teacher s = new Teacher();
            s.checkScore(120);
        } catch (ScoreException e) {
            e.printStackTrace();
        }
    }
}
