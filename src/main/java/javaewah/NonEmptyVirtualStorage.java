package javaewah;


/*
 * Copyright 2009-2012, Daniel Lemire, Cliff Moon, David McIntosh and Robert Becho
 * Licensed under APL 2.0.
 */
/**
 * This is a BitmapStorage that can be used to determine quickly
 * if the result of an operation is non-trivial... that is, whether
 * there will be at least on set bit.
 * 
 * @since 0.4.2
 * @author Daniel Lemire
 *
 */
public class NonEmptyVirtualStorage implements BitmapStorage {
  class NonEmptyException extends RuntimeException {
    private static final long serialVersionUID = 1L;    
  }
  /**
   * If the word to be added is non-zero, a NonEmptyException exception is thrown.
   * @see javaewah.BitmapStorage#add(long)
   */
  public int add(long newdata) {
    if(newdata!=0) throw new NonEmptyException(); 
    return 0;
  }

  /**
   * If the boolean value is true, then it throws a NonEmptyException exception,
   * otherwise, nothing happens.
   * 
   * @see javaewah.BitmapStorage#addStreamOfEmptyWords(boolean, long)
   */
  public int addStreamOfEmptyWords(boolean v, long number) {
    if(v) throw new NonEmptyException(); 
    return 0;
  }

  /**
   * throws a NonEmptyException exception
   * 
   * @see javaewah.BitmapStorage#addStreamOfDirtyWords(long[], long, long)
   */
  public long addStreamOfDirtyWords(long[] data, long start, long number) {
    throw new NonEmptyException();
  }

  /**
   * throws a NonEmptyException exception
   * 
   * @see javaewah.BitmapStorage#addStreamOfNegatedDirtyWords(long[], long, long)
   */
  public long addStreamOfNegatedDirtyWords(long[] data, long start, long number) {
    throw new NonEmptyException();
  }

  /**
   * Does nothing.
   * 
   * @see javaewah.BitmapStorage#setSizeInBits(int)
   */
  public void setSizeInBits(int bits) {
  }

}
