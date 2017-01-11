package be.kdg.shop.model.user.exceptions;

public class LoginException extends Exception
{
    /**
     * Deze exception wordt gesmeten wanneer iets fout gaat met het aanmelden
     * van een gebruiker. Bijvoorbeeld: fout password of foute gebruikersnaam
     *
     * @param message
     */
    public LoginException(String message)
    {
        super(message);
    }
}
