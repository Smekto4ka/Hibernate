package ru.oogis.helloworld;

import ru.oogis.model.helloworld.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.*;
import java.util.List;

public class HelloWorldJPA {

    public static void main(String[] args) {


    }

    public void start() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("HelloWorldPU");


        try {
            UserTransaction tx =  TM.getUserTransaction();
            tx.begin();

            EntityManager em = emf.createEntityManager();

            Message message = new Message();
            message.setText("Hello world");

            em.persist(message);


            tx.commit();
            em.close();
        } catch (HeuristicMixedException | HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (NotSupportedException e) {
            e.printStackTrace();
        }


        try {

            UserTransaction tx = TM.getUserTransaction();
            tx.begin();

            EntityManager em = emf.createEntityManager();

            List<Message> messages =
                    em.createQuery("select m from Message m").getResultList();
        `
            System.out.println(messages);

            messages.get(0).setText("EEEEEE");


            tx.commit();
            em.close();

        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (NotSupportedException e) {
            e.printStackTrace();
        }
    }
}
