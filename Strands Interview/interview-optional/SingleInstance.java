package com.strands.spf;

/**
 * <p>
 * Single instance in a multi threading environment
 * </p>
 * 
 * @author strands
 * 
 */
public class SingleInstance {

  // volatile ensures visibility across threads - without it, one thread could
  // see a half-constructed object due to instruction reordering
  private static volatile SingleInstance instance;

  private SingleInstance() {
    // TODO Auto-generated constructor stub
  }

  public static SingleInstance getInstance()
  {
    if (instance == null)
    {

      synchronized (SingleInstance.class)
      {
        if(instance == null)
        {
          instance = new SingleInstance();
        }
      }
    }

    return instance;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    SingleInstance a = SingleInstance.getInstance();
    SingleInstance b = SingleInstance.getInstance();
    System.out.println(a == b);

  }

}
