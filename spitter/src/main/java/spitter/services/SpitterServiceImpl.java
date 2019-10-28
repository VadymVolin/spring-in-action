package spitter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import spitter.data.Spitter;
import spitter.data.jpa.SpitterDAO;

public class SpitterServiceImpl implements SpitterService {

    @Autowired
    private SpitterDAO spitterDAO;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public void saveSpitter(Spitter spitter) {
        transactionTemplate.execute(new TransactionCallback<Void>() {
            public Void doInTransaction(TransactionStatus txStatus) {
                try {
                    spitterDAO.addSpitter(spitter);
                } catch (RuntimeException e) {
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
    }

    @Override
    public void editSpitter(Spitter spitter) {
        transactionTemplate.execute(new TransactionCallback<Void>() {
            public Void doInTransaction(TransactionStatus txStatus) {
                try {
                    spitterDAO.updateSpitter(spitter);
                } catch (RuntimeException e) {
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
    }
// TODO: start us transaction
    @Override
    public Spitter findSpitter(int id) {
        Spitter spitter = null;
        transactionTemplate.execute(new TransactionCallback<Void>() {
            public Void doInTransaction(TransactionStatus txStatus) {
                try {
                    spitter = spitterDAO.findById(id);
                } catch (RuntimeException e) {
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
        return null;
    }

    @Override
    public void deleteSpitter(Spitter spitter) {

    }

    @Override
    public void listSpitter() {

    }
}
