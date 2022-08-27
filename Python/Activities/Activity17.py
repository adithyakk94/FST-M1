# import pandas
import pandas

# Structure our data as a dictionary
data = {
    "Username": ["admin", "Charles", "Deku"],
    "Password": ["password", "Charl13", "AllMight"],
    }

# Create a new DataFrame using the data
dataframe = pandas.DataFrame(data)

# Print the DataFrame
print(dataframe)

# Write the data to a csv file
dataframe.to_csv("../resources/credentials.csv", index=False)
print("Data written to CSV file")