package teamproject.lam_simple.constants;

public class InterceptorConstants {
    public enum Whitelist {
        ALL("/"),
        USER_ADD("/user/signUp"),
        USER_FIND_ID("/user/findID"),
        USER_FIND_PW("/user/findPW"),
        CUSTOMER_CENTER("/customerCenter/**"),
        CITY("/city/**"),
        HOME("/main/**"),
        OTHER_SCHEDULE("/schedule/**"),
        REVIEW("/review/**"),
        LOGIN("/login"),
        LOGOUT("/logout"),
        CSS("/css/**"),
        ICO("/*.ico"),
        JS("/js/**"),
        FONT("/fonts/**"),
        IMG("/img/**"),
        ERROR("/error");

        private String path;

        Whitelist(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }
}
