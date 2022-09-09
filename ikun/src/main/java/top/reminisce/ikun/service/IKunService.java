package top.reminisce.ikun.service;

import org.springframework.validation.BindingResult;
import top.reminisce.ikun.pojo.dto.IKunInfo;
import top.reminisce.ikun.pojo.vo.Result;

/**
 * @author BlueSky
 * @date 2022/9/8
 */
public interface IKunService {
    /**
     * 识别真假ikun：答案提交是否正确
     * @return
     */
    Result distinguish();
    /**
     * 识别真假ikun：答案提交是否正确
     *
     * @param iKunInfo      请求体传来的提交数据，ikun的答案
     * @param bindingResult @Valid注解验证答案是否正确的结果，见spring-boot-starter-validation
     * @return 响应结果
     */
    Result distinguish(IKunInfo iKunInfo, BindingResult bindingResult);
}
