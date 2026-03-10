package fr.sesamvitale.apcv.ias.soap.mapper;

import fr.sesamvitale.apcv.authentification.decodage.exception.ApCVException;
import fr.sesamvitale.apcv.ias.dto.ContextePromixite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContexteApCVRepTypeMapper {
    private static final Logger LOG = LoggerFactory.getLogger(ContexteApCVRepTypeMapper.class);

    private ContexteApCVRepTypeMapper() {
    }

    public static fr.sesam_vitale.apcv.auth._1._0.ContexteApCVRepType fromContextePromixite(
            ContextePromixite contextePromixite) throws ApCVException {
        return ContexteApCVRepTypeMapperSupport.fromContextePromixite(
                contextePromixite,
                fr.sesam_vitale.apcv.auth._1._0.ContexteApCVRepType::new,
                fr.sesam_vitale.apcv.auth._1._0.ContexteApCVRepType::setDateFinValidite,
                fr.sesam_vitale.apcv.auth._1._0.ContexteApCVRepType::setIdentifiant,
                fr.sesam_vitale.apcv.auth._1._0.ContexteApCVRepType::setTokenApCV,
                LOG);
    }
}
