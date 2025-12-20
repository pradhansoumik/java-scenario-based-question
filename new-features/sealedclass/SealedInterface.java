package sealedclass;

/**
 *  tells that it can be subclassed but only by the permit lists classes
 *  "permits" type should be direct subclass of sealed interface or class.
 *  "permits" type, should be either "final", "sealed" or "non-sealed".
 *  All "permits" type should be present (future classes or interfaces not considered).
 *
 *
 */
public sealed interface SealedInterface permits ImplClass1, ImplClass2 {

    public void m1();
}
