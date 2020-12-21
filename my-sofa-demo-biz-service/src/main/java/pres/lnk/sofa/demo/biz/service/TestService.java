package pres.lnk.sofa.demo.biz.service;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import org.springframework.stereotype.Component;
import pres.lnk.sofa.demo.facade.FacadeService;

/**
 * @Author linnankun
 * @Date 2020/12/16
 */
@Component
@SofaService(uniqueId = "testService")
public class TestService implements FacadeService {
    @Override
    public String sayHello() {
        return "is me";
    }
}
