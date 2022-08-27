# Import pandas
import pandas

# Read the excel file and store it into a DataFrame
dataframe = pandas.read_excel("../resources/users.xlsx", sheet_name="Sheet1")

# Print the dataframe
print(dataframe)

# Print the number of rows and columns
print("====================================")
print("Number of rows and columns:", dataframe.shape)

# Print the data in the emails column only
print("====================================")
print("Emails:")
print(dataframe['Email'])

# Sort the data based on FirstName in ascending order and print the data
print("====================================")
print("Sorted data:")
print(dataframe.sort_values('FirstName'))