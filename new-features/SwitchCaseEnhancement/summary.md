
scenario 1: 
    if we are dealing with primitive objects
    int, string, float, bool, etc. then switch is more efficient than if-else statements.
    
    because - because the JVM can compile switch into optimized bytecode instructions (tableswitch or lookupswitch) that allow direct jump table lookups instead of evaluating each condition sequentially.

scenario 2:
    but if we are dealing with actual Object then it is better to use if-else statements instead of switch-case statements.
    because - 