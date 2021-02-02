public class Decide {

    Parameters parameters;
    boolean[] puv = new boolean[15];
    CMV cmv;
    boolean[][] pum = new boolean[15][15];
    boolean[] fuv = new boolean[15];
    LCM[][] lcm;

    /**
     * @param parameters, LCM, PUV and datapoints.
     * creates all necessary variables that is needed to check if a launch can be made
     */
    public Decide(Parameters parameters, LCM[][] lcm, boolean[] puv, Point[] points) {

        this.parameters = parameters;
        this.lcm = lcm;
        this.puv = puv;
        this.cmv = new CMV(parameters, points);
        this.cmv.populate();
        //this.pum = setPUM();
        //this.fuv = setFUV();

    }

    /**
     * Checks all conditions, and if all are met or not, returns a boolean
     * @return a boolean, true if launch is a go, false otherwise
     */
    public boolean Decide(){
        //TODO
        //check all conditions inside here
        return false;
    }

}


