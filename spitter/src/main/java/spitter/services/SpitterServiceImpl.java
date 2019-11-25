package spitter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import spitter.data.Spitter;
import spitter.data.jpa.SpitterDAO;

public class SpitterServiceImpl implements SpitterService {

    @Autowired
    private SpitterDAO spitterDAO;
    @Autowired
    private TransactionTemplate transactionTemplate;

    public SpitterServiceImpl(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
        this.transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        this.transactionTemplate.setTimeout(30);
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                spitterDAO.addSpitter(spitter);
            }
        });
    }

    @Override
    public void editSpitter(Spitter spitter) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                spitterDAO.updateSpitter(spitter);
            }
        });
    }
// TODO: start us transaction
    @Override
    public Spitter findSpitter(int id) {
        Spitter spitter = transactionTemplate.execute(new TransactionCallback<Spitter>() {

            @Override
            public Spitter doInTransaction(TransactionStatus transactionStatus) {
                return spitterDAO.findById(id);
            }
        });
        return spitter;
    }

    @Override
    public void deleteSpitter(Spitter spitter) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                spitterDAO.delete(spitter);
            }
        });
    }

    @Override
    public void listSpitter() {

    }
}
