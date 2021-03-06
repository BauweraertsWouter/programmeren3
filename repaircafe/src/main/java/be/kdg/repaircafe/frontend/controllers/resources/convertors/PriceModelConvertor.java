package be.kdg.repaircafe.frontend.controllers.resources.convertors;

import be.kdg.repaircafe.backend.dom.repairs.RepairDetails;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PriceModelConvertor implements Converter<String, RepairDetails.PriceModel>
{
    @Override
    public RepairDetails.PriceModel convert(String s)
    {
        if (s.contains("Fixed"))
            return RepairDetails.PriceModel.FIXED;

        return RepairDetails.PriceModel.PER_HOUR;
    }
}
