package bigweb;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qfedu.bigweb.util.CommonUtil;

public class CommonUtilTest {

	@Test
	public void testGenerateVC() {
		for (int i = 0; i < 10; ++i) {
			String vc = CommonUtil.generateVC(4);
			System.out.println(vc);
			assertEquals(4, vc.length());
		}
	}

}
