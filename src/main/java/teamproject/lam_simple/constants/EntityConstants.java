package teamproject.lam_simple.constants;

public class EntityConstants {

    public enum CityInfoCategory {
        INTRO("Intro", "intro/"),
        FOOD("Food", "food/"),
        VIEW("View", "view/");
        private final String text;
        private final String path;

        CityInfoCategory(String text, String path) {
            this.text = text;
            this.path = path;
        }

        public String getText() {
            return this.text;
        }

        public String getImgUrlPath() {
            return this.path;
        }
    }
}
