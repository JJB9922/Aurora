package processing

import processing.core.PApplet

class Hello {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            PApplet.main("processing.HelloProcessing")
        }
    }
}

class HelloProcessing() : PApplet() {
    private var time = 0f

    override fun settings() {
        size(1200, 1000)
    }

    override fun setup() {
        colorMode(HSB, 360f, 255f, 255f, 255f)
        background(0)
        frameRate(60.0f)

    }

    override fun draw() {
        drawStars()

        fill(0f, 0f, 0f, 5f)
        rect(0f, 0f, width.toFloat(), height.toFloat())

        drawAurora()
    }

    private fun drawStars() {
        if (frameCount == 1) {
            for (i in 0 until 2000) {
                val x = random(width.toFloat())
                val y = random(height / 2f)
                val size = random(1f, 3f)
                val brightness = random(150f, 255f)
                fill(0f, 0f, brightness)
                noStroke()
                ellipse(x, y, size, size)
            }
        }
    }

    private fun drawAurora() {
        noStroke()
        val layers = 5
        for (i in 0 until layers) {
            val alpha = map(i.toFloat(), 0f, layers.toFloat(), 30f, 100f)
            val baseHue = map(mouseX.toFloat(), 0f, width.toFloat(), 100f, 250f)
            val hue = (baseHue + i * 20) % 360

            fill(hue, 200.0f, 200.0f, alpha)

            beginShape()
            for (x in 0..width step 5) {
                val noiseFactor = noise(x * 0.002f, time + i * 0.5f)
                val y = height / 2 + noiseFactor * 150f + sin(time * (0.5f + i * 0.1f) + x * 0.01f) * 30f
                vertex(x.toFloat(), y)
            }
            vertex(width.toFloat(), height.toFloat())
            vertex(0f, height.toFloat())
            endShape(CLOSE)
        }
        time += 0.002f
    }
}


fun main(args: Array<String>) {
    PApplet.main("processing.HelloProcessing")
}