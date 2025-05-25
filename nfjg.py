import random
import matplotlib.pyplot as plt

# Generate random data for the histogram
data = [random.gauss(0, 1) for _ in range(1000)]  # 1000 samples from a normal distribution

# Create the histogram
plt.style.use('seaborn-darkgrid') 

# Add a title and labels for the axes
plt.title("Histogram of Random Data")
plt.xlabel("Value")
plt.ylabel("Frequency")

# Enable the grid for better readability
plt.grid(True)

# Display the plot
plt.show()
