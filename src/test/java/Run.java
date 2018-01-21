import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 开发人:刘文
 * 日期:  2017/11/25.
 * 功能描述:
 */
public class Run {


    Logger logger = LoggerFactory.getLogger(Run.class);

    @Test
    public void run(){
        logger.info("测试 :{}","信息");
    }
}
