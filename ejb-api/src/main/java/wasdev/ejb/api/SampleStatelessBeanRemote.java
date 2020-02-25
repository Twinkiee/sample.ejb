package wasdev.ejb.api;


public interface SampleStatelessBeanRemote extends SampleStatelessBean {

  String callCicsSample(byte[] input);
}
