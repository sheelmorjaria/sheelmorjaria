

        package com.example.user.apidemo.model;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

        import io.realm.RealmObject;
        import io.realm.annotations.PrimaryKey;

        public class CakeModel extends RealmObject {
    @PrimaryKey
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("image")
    @Expose
    private String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}