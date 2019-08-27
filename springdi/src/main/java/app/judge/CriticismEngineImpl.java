package app.judge;

import java.util.ArrayList;
import java.util.List;

public class CriticismEngineImpl implements CriticismEngine {

    private List<String> criticismPool;

    public CriticismEngineImpl() {
    }

    public void setCriticismPool(List<String> criticismPool) {
        this.criticismPool = criticismPool;
    }

    @Override
    public String getCriticism() {
        int i = (int) (Math.random() * criticismPool.size());
        return criticismPool.get(i);
    }
}
