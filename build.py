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

# Generate HTML documentation with styling
html_template = """<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Kattis Problems - Simple Table</title>
  <style>
   body {
    font-family: Arial, sans-serif;
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
    background: #f5f5f5;
   }
   .nav-link {
    display: inline-block;
    margin-bottom: 20px;
    padding: 10px 20px;
    background: #00ffff;
    color: #0a0e27;
    text-decoration: none;
    border-radius: 5px;
    font-weight: bold;
    transition: all 0.3s;
   }
   .nav-link:hover {
    background: #00cccc;
    transform: translateY(-2px);
    box-shadow: 0 5px 15px rgba(0,255,255,0.3);
   }
   h1 {
    color: #333;
   }
   table {
    width: 100%;
    border-collapse: collapse;
    background: white;
    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
   }
   th, td {
    padding: 12px;
    text-align: left;
    border-bottom: 1px solid #ddd;
   }
   th {
    background: #0a0e27;
    color: #00ffff;
    font-weight: bold;
   }
   tr:hover {
    background: #f9f9f9;
   }
   a {
    color: #0066cc;
    text-decoration: none;
   }
   a:hover {
    text-decoration: underline;
   }
  </style>
</head>
<body>
  <a href="index.html" class="nav-link">← Back to Interactive Dashboard</a>
  <h1>Solved Problems</h1>
</body>
</html>"""

soup = BeautifulSoup(html_template, 'html.parser')
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
