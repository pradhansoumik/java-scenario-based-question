public class TryToBreakImmutabilityClass
{

    /**
     * if you try to extend Custom ImmutableClass then it will give you CTE, as
     * Immutable class is final.
     * CTE: create constructor matching super,
     * CTE: make CustomImmutableClass not final.
     *
     */
}
