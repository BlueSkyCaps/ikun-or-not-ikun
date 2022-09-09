package top.reminisce.ikun.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.reminisce.ikun.anno.IsiKun;

import javax.validation.constraints.DecimalMax;

/**
 * @author BlueSky
 */
@Data
@AllArgsConstructor
@IsiKun
public class IKunInfo {
    @DecimalMax(value = "50", message = "坤坤的鞋码太大了哦！")
    private double shoeSize;
    private String assistanceColor;
    private String dreamsLand;
    private String sports;
}
