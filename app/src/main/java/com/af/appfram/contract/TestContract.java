package com.af.appfram.contract;

/**
 * Created by winton on 2017/6/25.
 */

public interface TestContract {

    public interface View{

       void  showResult(String text);
    }

    public interface Presenter{
      void   testGet();
    }

}
