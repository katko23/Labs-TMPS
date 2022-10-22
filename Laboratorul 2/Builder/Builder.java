package Builder;

    class House{
        // required param
        private int nr_of_walls;
        private int nr_of_doors;
        private int nr_of_windows;

        //optional
        private boolean isMedieval;
        private boolean isRococo;
        private int nr_of_towers;
        private int nr_of_guns;
        private int nr_of_staff;

        public int getNr_of_walls(){
            return nr_of_walls;
        }

        public int getNr_of_doors() {
            return nr_of_doors;
        }

        public int getNr_of_windows() {
            return nr_of_windows;
        }

        public boolean isMedieval() {
            return isMedieval;
        }

        public boolean isRococo() {
            return isRococo;
        }

        public int getNr_of_towers() {
            return nr_of_towers;
        }

        public int getNr_of_guns() {
            return nr_of_guns;
        }

        public int getNr_of_staff() {
            return nr_of_staff;
        }

        private House(HouseBuilder builder){
            this.isMedieval = builder.isMedieval;
            this.isRococo = builder.isRococo;
            this.nr_of_walls = builder.nr_of_walls;
            this.nr_of_doors = builder.nr_of_doors;
            this.nr_of_windows = builder.nr_of_windows;
            this.nr_of_towers = builder.nr_of_towers;
            this.nr_of_guns = builder.nr_of_guns;
            this.nr_of_staff = builder.nr_of_staff;
        }

        public static class HouseBuilder{
            // required param
            private int nr_of_walls;
            private int nr_of_doors;
            private int nr_of_windows;

            //optional
            private boolean isMedieval;
            private boolean isRococo;
            private int nr_of_towers;
            private int nr_of_guns;
            private int nr_of_staff;

            public HouseBuilder(int nr_walls,int nr_doors,int nr_windows){
                this.nr_of_walls = nr_walls;
                this.nr_of_doors = nr_doors;
                this.nr_of_windows = nr_windows;
            }

            public HouseBuilder setMedieval(boolean medieval) {
                this.isMedieval = medieval;
                return this;
            }

            public HouseBuilder setRococo(boolean rococo){
                this.isRococo = rococo;
                return this;
            }

            public HouseBuilder hasTowers(int nr_of_towers){
                this.nr_of_towers = nr_of_towers;
                return this;
            }

            public HouseBuilder hasGuns(int nr_guns){
                this.nr_of_guns = nr_guns;
                return this;
            }

            public HouseBuilder hasStaff(int nr_staff){
                this.nr_of_staff = nr_staff;
                return this;
            }

            public House build(){
                return new House(this);
            }
        }
    }
