package jm.mind.mobile.profile;

/**
 * Created by kminor on 2/18/2017.
 */
public class PlaceNum {

    private String place;

    private String num;

    PlaceNum(String place, String num){

        this.place=place;

        this.num=num;

    }

    public void setPlace(String place){

        this.place=place;

    }

    public void setNum(String num){

        this.num=num;

    }

    public String getPlace(){

        return place;

    }

    public String getNum(){

        return num;

    }

}
