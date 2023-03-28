import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *   测试模版，以后直接从这里复制即可
 */
public class XLTest {

        @Before
        public void init(){


        }

        /**
         *
         *
         */
        @Test
        public void test01(){
                System.out.println("No"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")));
        }

        @Test
        public void test02(){
                boolean flag = new BigDecimal("10000").compareTo(new BigDecimal("5000")) <0;
                System.out.println(flag);
        }

        @Test
        public void test03(){
                System.out.println(new java.sql.Date(System.currentTimeMillis()));



        }

        @Test
        public void getlinkNumber() {

        }


}
