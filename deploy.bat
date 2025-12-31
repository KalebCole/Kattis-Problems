@echo off
echo ============================================
echo  Deploy Kattis Dashboard to GitHub Pages
echo ============================================
echo.

echo [1/4] Generating latest dashboard...
python generate_dashboard.py
if %ERRORLEVEL% NEQ 0 (
    echo [ERROR] Dashboard generation failed!
    pause
    exit /b 1
)

echo.
echo [2/4] Staging files for commit...
git add .github/workflows/deploy-dashboard.yml
git add dashboard.html
git add generate_dashboard.py
git add update_dashboard.bat
git add deploy.bat
git add DASHBOARD_*.md

echo.
echo [3/4] Creating commit...
git commit -m "Add automated dashboard deployment to GitHub Pages"

echo.
echo [4/4] Pushing to GitHub...
git push origin master

echo.
echo ============================================
echo  Deployment initiated!
echo ============================================
echo.
echo Your dashboard will be available at:
echo https://kalebcole.github.io/Kattis-Problems/
echo.
echo NOTE: First-time setup requires enabling GitHub Pages:
echo 1. Go to: https://github.com/KalebCole/Kattis-Problems/settings/pages
echo 2. Under "Build and deployment"
echo 3. Source: GitHub Actions
echo.
echo The dashboard will be live in a few minutes!
echo.
pause
