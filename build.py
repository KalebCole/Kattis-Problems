from dotenv import load_dotenv
import os
from datetime import datetime
from bs4 import BeautifulSoup
from autokattis import Kattis

# Load environment variables from a .env file located in the same directory as this script
load_dotenv()

# Retrieve username and password from environment variables
kattis_username = os.environ.get('KATTIS_USERNAME')
kattis_password = os.environ.get('KATTIS_PASSWORD')

kt = Kattis(kattis_username, kattis_password)

# Dictionary mapping file extensions to programming languages for generating badges
image_mapper = {
    'py':   'python',
    'c':    'c',
    'cpp':  'cpp',
    'cs':   'csharp',
    'go':   'go',
    'hs':   'haskell',
    'java': 'java',
    'kt':   'kotlin',
    'php':  'php',
    'rb':   'ruby',
    'js':   'javascript'
}

# Function to get the image file name for a programming language badge
def get_image(extension):
    return f'images/{image_mapper.get(extension, "default")}.png'

# List to hold content for README and HTML documentation
readme_contents = []
html_contents = []

# Directory containing solved problems
solved_dir = 'Solved'

# Iterate through files in the Solved directory
for file in os.listdir(solved_dir):
    # Skip directories
    if os.path.isdir(os.path.join(solved_dir, file)):
        continue

    # Extract the problem slug and file extension
    problem_slug, extension = os.path.splitext(file)
    extension = extension.lstrip('.')  # Remove leading dot
    if '_' in problem_slug:
        problem_slug = problem_slug.replace('_', '')

    # Construct the URL for the problem
    problem_url = f'https://open.kattis.com/problems/{problem_slug.lower()}'

    # Generate language badge link
    language_badge = get_image(extension)

    # Append details to README and HTML contents lists
    readme_contents.append(f"- [{problem_slug}]({problem_url}) ![Language]({language_badge})\n")
    html_contents.append((problem_slug, problem_url, language_badge))

# Current date for documentation
today = datetime.today().strftime('%d %B %Y')

# Generate README.md content
with open('README.md', 'w') as readme_file:
    readme_file.write(f'# Solved Problems as of {today}\n')
    readme_file.write(f'## Total Problems: {len(kt.problems())}\n')
    readme_file.writelines(readme_contents)

# Generate HTML documentation (local only, not deployed)
soup = BeautifulSoup("<html><body><h1>Solved Problems</h1></body></html>", 'html.parser')
soup.body.append(soup.new_tag('p', string=f'Last updated: {today}'))

# Create a table for the problems
table = soup.new_tag('table')

# Create and add a header row
header_row = soup.new_tag('tr')
headers = ["Problem Name", "Language Badge"]
for header_text in headers:
    header = soup.new_tag('th')
    header.string = header_text
    header_row.append(header)
table.append(header_row)  # Add the header row to the table

for problem_slug, problem_url, language_badge in html_contents:
    row = soup.new_tag('tr')
    
    # Problem column
    problem_cell = soup.new_tag('td')
    problem_link = soup.new_tag('a', href=problem_url)
    problem_link.string = problem_slug
    problem_cell.append(problem_link)
    row.append(problem_cell)
    
    # Language badge column
    badge_cell = soup.new_tag('td')
    badge_img = soup.new_tag('img', src=language_badge)
    badge_cell.append(badge_img)
    row.append(badge_cell)
    
    table.append(row)

soup.body.append(table)

# Write HTML content to file
with open('index.html', 'w') as html_file:
    html_file.write(soup.prettify())

print('Documentation generation completed.')

# Optionally generate the interactive dashboard
try:
    import subprocess
    print('\nGenerating interactive dashboard...')
    result = subprocess.run(['python', 'generate_dashboard.py'],
                          capture_output=True,
                          text=True)
    if result.returncode == 0:
        print('Interactive dashboard generated successfully!')
        print('Open kattis_dashboard.html to view your progress.')
    else:
        print('Note: Dashboard generation skipped (generate_dashboard.py not found or error occurred)')
except Exception as e:
    print(f'Note: Dashboard generation skipped ({str(e)})')
