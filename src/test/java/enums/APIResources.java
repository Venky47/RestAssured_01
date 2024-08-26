package enums;
//enum is a special class in java which has collection of constants or methods
public enum APIResources {
    AddPlaceAPI("/maps/api/place/add/json"),
    DelPlaceAPI("/maps/api/place/delete/json"),
    GetPlaceAPI("/maps/api/place/get/json");
private String resources;
    APIResources(String resources) {
        this.resources=resources;    //value of AddPlaceAPI, DelPlaceAPI & GetPlaceAPI are stored in resources
    }

    public String getResources(){
        return resources;         //will get the stored resources
    }
}
