package teamproject.lam_simple.constants;

public class CategoryConstants {
    public enum CityCategory{
        SE("서울","SEOUL"),
        GN("강릉","GANGNEUNG"),
        GJ("경주","GYEONGJU"),
        BS("부산","BUSAN"),
        YS("여수","YEOSU"),
        JJ("제주","JEJU");
        private final String nameKR;
        private final String nameEN;
        CityCategory(String nameKR, String nameEN) {
            this.nameKR = nameKR;
            this.nameEN = nameEN;
        }
        public String getNameKR() {return nameKR;}
        public String getNameEN() {return nameEN;}
    }


    public enum CityTransportCategory {
        SUBWAY("지하철역",4),
        BUS("버스 노선",5),
        BICYCLE("공공자전거",6),
        BUS_TERMINAL("버스 터미널",3),
        TRAIN("기차역",2),
        AIRPORT("공항",1);
        private final String nameKR;
        private final int score;
        CityTransportCategory(String nameKR,int score) {
            this.nameKR = nameKR;
            this.score = score;
        }
        public int getScore() {
            return this.score;
        }
        public String getNameKR() {return this.nameKR;}
    }
}
