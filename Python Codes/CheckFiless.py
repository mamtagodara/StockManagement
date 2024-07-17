import os

def generate_expected_filenames(start=2, end=100, step=2):
    expected_filenames = []
    for i in range(start, end, step):
        filename = f"page {i}n{i+1}.pdf"
        expected_filenames.append(filename)
    return expected_filenames

def check_missing_files(directory, expected_filenames):
    try:
        existing_files = set(os.listdir(directory))
        print(f"Existing files in directory '{directory}': {existing_files}")
    except FileNotFoundError:
        print(f"Error: The directory {directory} does not exist.")
        return []
    except PermissionError:
        print(f"Error: Permission denied to access {directory}.")
        return []

    missing_files = [filename for filename in expected_filenames if filename not in existing_files]
    return missing_files

def main():
    directory = "C:\\Users\\Mamta\\Desktop\\passport"  # Ensure this path is correct
    start = 2  # Starting number for the pattern
    end = 100  # Ending number for the pattern (adjust as needed)
    step = 2   # Step size for the pattern

    expected_filenames = generate_expected_filenames(start, end, step)
    print(f"Expected filenames: {expected_filenames}")
    
    missing_files = check_missing_files(directory, expected_filenames)

    if missing_files:
        print("Missing files:")
        for file in missing_files:
            print(file)
    else:
        print("All files are present and correctly named.")

if __name__ == "__main__":
    main()
