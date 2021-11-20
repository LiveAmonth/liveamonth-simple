package teamproject.lam_simple.constants;

public class CategoryConstants {
    public enum CityCategory{SE,GN,GJ,BS,YS,JJ}
    public enum CityTransportGrade{T_GOOD,T_FAIR,T_POOR}
    public enum CityWeatherMonth{JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC}
    public enum CityTransportCategory {
        T_SUBWAY(4),
        T_BUS(5),
        T_BICYCLE(6),
        T_BUS_TERMINAL(3),
        T_TRAIN(2),
        T_AIRPORT(1);
        private final int score;
        CityTransportCategory(int score) {this.score = score;}
        public int getScore() {
            return this.score;
        }
    }
    public enum CustomerCenterCategory{faq,personalTerms,termsAndConditions,notice}
}
