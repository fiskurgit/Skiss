# Skiss
Skiss (Swedish: _Sketch_): an extremely basic 2D animation system for Android.  

It's little more than a game loop, but it's very fast and lightweight and has a structure and syntax influenced by [Processing](https://processing.org/).  

## Setup

Add a `SkissView` to your layout:

```xml
<oppen.skiss.lib.SkissView
    android:id="@+id/skiss_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```

Create a subclass of `Skiss` (see example below), pass in the view and start from your Activity/Fragment:

```kotlin
DemoSkiss(skiss_view).start()
```

## Example

There are a few convenience methods (eg. `fill`, `line`, `circle` etc) but the standard View Canvas is also available:

```kotlin
package oppen.skiss.example

import android.graphics.Canvas
import oppen.skiss.lib.Skiss
import oppen.skiss.lib.SkissView
import oppen.skiss.lib.color
import oppen.skiss.lib.random

class DemoSkiss(view: SkissView): Skiss(view) {

    private val background = color("#1d1d1d")
    private val red = color("#ff0000")
    private val pale = color("#55ffffff")
    private var y = 0f

    override fun setup(width: Int, height: Int) {}

    override fun update(canvas: Canvas) {
        background(background)

        y += 2
        if (y > height) y = 0f

        stroke(red)
        line(0f, y, width.toFloat(), y)

        noStroke()
        fill(pale)
        repeat(100) {
            circle(random(width), random(height), random(5, 40))
        }
    }
}
```

## Reference

#### smooth/noSmooth

Anti-aliasing is off by default, screens on modern devices are so high resolution it may not be needed at all. Skiss uses the same beginner-friendly naming as Processing, turn anti-aliasing on in setup:

```kotlin
override fun setup(width: Int, height: Int) {
    smooth()
}
```

#### stroke/noStroke

Stroke is used for lines, points, and shape borders. Supply a colour int for Skiss to draw with: `stroke(aColour)`. Be sure to pre calculate the colour value and assign to a field, avoid any allocations in the update block. Turn off stroke drawing with `noStroke()`

#### fill/noFill

Same as stroke above but for shape fills, eg:

```kotlin
fill(red)
circle(100, 100, 20)
```

### Development References
* [Custom Drawing](https://developer.android.com/training/custom-views/custom-drawing)
* [Optimizing the View](https://developer.android.com/training/custom-views/optimizing-view)
* [Hardware acceleration](https://developer.android.com/guide/topics/graphics/hardware-accel.html)
* [Getting Started with Android Canvas Drawing](https://medium.com/over-engineering/getting-started-with-drawing-on-the-android-canvas-621cf512f4c7)
* [Android Canvas Drawing: Useful Graphics Classes & Operations](https://medium.com/over-engineering/android-canvas-drawing-useful-graphics-classes-operations-2803e435e848)



