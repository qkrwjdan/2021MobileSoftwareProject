package com.example.finalproject;

public class Items {

    public static class Item {
        String item_name;
        int image_id;
        int image_id2;
        String item_url;
        String item_description;
        int price;

        public Item(int id, int id2, String name, String url, String desc, int price) {
            this.image_id = id;
            this.image_id2 = id2;
            this.item_name = name;
            this.item_url = url;
            this.item_description = desc;
            this.price = price;
        }

        public String getImageName() {
            return item_name;
        }
        public int getImageID() {
            return image_id;
        }
        public int getImageID2() { return image_id2; }
        public String getImageURL() {
            return item_url;
        }
        public String getItemDescription(){
            return item_description;
        }
        public int getPrice() { return price; }
    }

}
