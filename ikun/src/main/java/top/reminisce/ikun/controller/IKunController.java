package top.reminisce.ikun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import top.reminisce.ikun.pojo.dto.IKunInfo;
import top.reminisce.ikun.pojo.vo.Result;
import top.reminisce.ikun.service.IKunService;

import javax.validation.Valid;


/**
 * @author BlueSky
 */
@Controller
@CrossOrigin(origins={"*"})
public class IKunController {
    @Autowired
    private IKunService iKunService;

    @PostMapping("/ikun/distinguish")
    @ResponseBody
    public Result kun(@RequestBody @Valid IKunInfo iKunInfo, BindingResult bindingResult){
        return this.iKunService.distinguish(iKunInfo, bindingResult);

    }
}
