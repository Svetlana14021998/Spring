public class MainApp {
    public static void main(String[] args) {

        SessionFactoryUt sessionFactoryUt = new SessionFactoryUt();
        sessionFactoryUt.init();
        try {
            //do smth
            ProductDao productDao = new ProductDaoImp(sessionFactoryUt);
            //System.out.println(productDao.findById(1L).toString());
         /*   System.out.println(productDao.findAll());
            productDao.deleteById(1L);*/
            System.out.println(productDao.findAll());
            Product p1 = productDao.findById(1L);
            p1.setPrice(10000);
            productDao.saveOrUpdate(p1);
            System.out.println(productDao.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUt.close();
        }

    }
}
