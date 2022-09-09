package top.reminisce.ikun.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import top.reminisce.ikun.common.ResultPack;
import top.reminisce.ikun.pojo.dto.IKunInfo;
import top.reminisce.ikun.pojo.vo.Result;
import top.reminisce.ikun.service.IKunService;

import java.util.List;

/**
 * @author BlueSky
 * @date 2022/9/8
 */
@Service
public class IKunServiceImpl implements IKunService {
    @Override
    public Result distinguish() {
        throw new NotImplementedException();
    }

    @Override
    public Result distinguish(IKunInfo iKunInfo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            StringBuilder sb = new StringBuilder();
            for (ObjectError error:errors) {
                sb.append(error.getDefaultMessage()).append(System.lineSeparator());
            }
            int index = sb.lastIndexOf(System.lineSeparator());
            sb.delete(index, sb.length());
            return ResultPack.reject(sb.toString());
        }
        return ResultPack.fluent("这年头真iKun不多了我的朋友，泪奔！");
    }
}
