/* this isnt necessarily shit code, however
 * this function has a side effect other than validating user/pass!
 * it calls initialize().
 * this results in loss of session data when checking login credentials.
 * now login is temporally coupled to session init.
 *
 * fix? rename to checkPasswordAndInitSession(...), but that violates ONE FUNC ONE PURPOSE
 * better fix? initialize session outside of this validator, possibly in calling function.
 */

public class UserValidator {
    private Cryptographer cryptographer;

    public boolean checkPassword(String userName, String password) {
        User user = UserGateway.findByName(userName);
        if (user != User.NULL) {
            String codedPhrase = user.getPhraseEncodedByPassword();
            String phrase = cryptographer.decrypt(codedPhrase, password);
            if ("Valid Password".equals(phrase)) {
                Session.initialize();
                return true;
            }
        }
        return false;
    }
}

