package fr.sesamvitale.apcv.ias.soap.mapper;

import fr.sesamvitale.apcv.authentification.decodage.exception.ApCVError;
import fr.sesamvitale.apcv.authentification.decodage.exception.ApCVException;
import fr.sesamvitale.apcv.ias.common.XMLGregorianCalendarUtil;
import fr.sesamvitale.apcv.ias.dto.ContextePromixite;
import org.slf4j.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

final class ContexteApCVRepTypeMapperSupport {

    private ContexteApCVRepTypeMapperSupport() {
    }

    static <T> T fromContextePromixite(
            ContextePromixite contextePromixite,
            Supplier<T> factory,
            BiConsumer<T, javax.xml.datatype.XMLGregorianCalendar> dateFinValiditeSetter,
            BiConsumer<T, String> identifiantSetter,
            BiConsumer<T, String> tokenApCVSetter,
            Logger logger) throws ApCVException {
        final T contextePromixiteRepType = factory.get();

        try {
            dateFinValiditeSetter.accept(
                    contextePromixiteRepType,
                    XMLGregorianCalendarUtil.toXMLGregorianCalendar(contextePromixite.getDateFinValidite()));
            identifiantSetter.accept(contextePromixiteRepType, contextePromixite.getIdentifiant());
            tokenApCVSetter.accept(contextePromixiteRepType, contextePromixite.getIdentifiant());

            return contextePromixiteRepType;
        } catch (DatatypeConfigurationException e) {
            logger.error("Convertion ContexteAssureMessageDTO -> ContexteApCVRepType", e);
            throw new ApCVException(ApCVError.ERREUR_INTERNE_SERVEUR);
        }
    }
}
