class Coconut implements  app.scripting2.ICoconut {

    @Override
    void drinkThemBothUp() {
        println "U put the lime in the coconut ..."
        println "and drink 'em both up..."
        println "U put the lime in the coconut ..."
        lime.drink();
    }
    app.scripting.Lime lime;
}
