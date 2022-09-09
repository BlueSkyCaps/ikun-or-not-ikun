package top.reminisce.ikun.anno;

import top.reminisce.ikun.pojo.dto.IKunInfo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author BlueSkyCarry
 */
public class IsiKunConstantValidator implements ConstraintValidator<IsiKun, IKunInfo> {

    private static final IKunInfo REAL_IKUN_INFO_COMPARATOR =
            new IKunInfo(43.5, "王者金", "马尔代夫", "ctrl");

    @Override
    public void initialize(IsiKun constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(IKunInfo iKunInfo, ConstraintValidatorContext constraintValidatorContext) {
        iKunInfo.setSports(iKunInfo.getSports() == null ? null : iKunInfo.getSports().toLowerCase());
        return iKunInfo.equals(REAL_IKUN_INFO_COMPARATOR);
    }
}
