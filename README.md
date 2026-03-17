# Navigation3 Example

This project demonstrates the usage of the new Navigation3 library in Jetpack Compose.

## Key Concepts

### Backstack Management
In Navigation3, you manage the backstack manually using a list of keys. In this example, we use `mutableStateListOf<Any>`.

```kotlin
val backStack = remember { mutableStateListOf<Any>(ScreenList) }
```

### NavDisplay
`NavDisplay` is the main composable for displaying content based on the backstack. It takes three primary parameters:
- `backStack`: The current list of screens/keys.
- `onBack`: A lambda to handle back navigation.
- `entryProvider`: A lambda that maps a key to a `NavEntry`.

### NavEntry
`NavEntry` defines the content and configuration for a specific destination in the navigation graph.

```kotlin
NavEntry(key) {
    ScreenA(onClick = {
        backStack.add(ScreenDetails("someId"))
    })
}
```

## Example Flow
1. **ScreenList**: The initial screen. Clicking a button adds `ScreenDetails` to the backstack.
2. **ScreenDetails**: Displays details for an ID. Clicking a button adds `ScreenC`.
3. **ScreenC**: Another destination. Clicking a button adds `screenD`.
4. **screenD**: Final destination in this sequence. Clicking a button navigates back to `ScreenList` by adding it to the stack.

## Dependencies
This project uses the following Navigation3 dependencies:
- `androidx.navigation3:navigation3-runtime`
- `androidx.navigation3:navigation3-ui`
