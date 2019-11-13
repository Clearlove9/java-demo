package com.aeron.icoder.effective;

public class Facts {
    private int servingSize;//required
    private int servings;//required
    private int calories;//optional
    private int fat;//optional
    private int sodium;//optional
    private int carbohydrate;//optional

    public static class Builder {
        private int servingSize;//required
        private int servings;//required

        private int calories;//optional
        private int fat;//optional
        private int sodium;//optional
        private int carbohydrate;//optional

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            this.calories = val;
            return this;
        }

        public Builder fat(int val) {
            this.fat = val;
            return this;
        }

        public Builder sodium(int val) {
            this.sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            this.carbohydrate = val;
            return this;
        }


        public Facts build() {
            return new Facts(this);
        }

    }

    private Facts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

}
